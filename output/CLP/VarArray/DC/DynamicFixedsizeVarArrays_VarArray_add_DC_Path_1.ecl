:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_2143431083),
(Var_2143431083 #> 0),
nth1(1,Arg_dimensionSizes,Var_119358627),
nth1(1,Self_dimensionSizes,Var_2073621255),
length(Arg_dimensionSizes,Var_1208121709),
length(Self_dimensionSizes,Var_873610597),
nth1(1,Arg_dimensionSizes,Var_1497845528),
nth1(1,Self_dimensionSizes,Var_1710989308),
length(Arg_dimensionSizes,Var_1047087935),
length(Self_dimensionSizes,Var_464887938),
(((Var_464887938 #\= Var_1047087935) , (Var_1710989308 #= Var_1497845528)) ; ((Var_873610597 #= Var_1208121709) , (Var_2073621255 #\= Var_119358627))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
