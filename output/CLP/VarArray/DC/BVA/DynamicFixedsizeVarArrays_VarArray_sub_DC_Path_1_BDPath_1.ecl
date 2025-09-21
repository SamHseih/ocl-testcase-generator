:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_sub_DC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_1031061344),
(Var_1031061344 #> 0),
nth1(1,Self_dimensionSizes,Var_173099767),
nth1(1,Arg_dimensionSizes,Var_112797691),
length(Self_dimensionSizes,Var_1045997582),
length(Arg_dimensionSizes,Var_1337335626),
nth1(1,Self_dimensionSizes,Var_1336996537),
nth1(1,Arg_dimensionSizes,Var_7967307),
length(Self_dimensionSizes,Var_2073707154),
length(Arg_dimensionSizes,Var_78204644),
(((Var_78204644 #\= Var_2073707154) , (Var_7967307 #= Var_1336996537)) ; ((Var_1337335626 #= Var_1045997582) , (Var_112797691 #\= Var_173099767))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
