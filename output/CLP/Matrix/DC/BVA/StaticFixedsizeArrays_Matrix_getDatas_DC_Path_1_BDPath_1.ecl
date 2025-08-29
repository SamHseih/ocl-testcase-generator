:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_getDatas_DC_Path_1_BDPath_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [2, 2],

decl_Array(Self_datas,Self_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
(Result = Self_datas),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas]).
